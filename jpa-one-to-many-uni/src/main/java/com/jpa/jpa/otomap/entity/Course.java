package com.jpa.jpa.otomap.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * One Instructor can have many courses -> Instructor to Course relation is one to many
 * Many courses can have one instructor -> Course to instructor relation is many to one
 */
@Entity
@Table(name = "course")
public class Course {
    //define our fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    /**
     * Note - the JoinColumn is not present in course table and is in review table and this is okay.
     */
    private List<Review> reviews;

    //define constructors
    public Course(){

    }

    public Course(String title) {
        this.title = title;
    }

    //define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    //Add a convenience method for adding reviews
    public void addReview(Review review){
        setReviews(Objects.isNull(reviews) ? new ArrayList<>() : reviews);
        if(review != null){
            this.getReviews().add(review);
        }
    }

    //annotate fields
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
