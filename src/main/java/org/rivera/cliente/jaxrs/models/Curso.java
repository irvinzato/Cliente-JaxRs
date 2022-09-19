package org.rivera.cliente.jaxrs.models;

import jakarta.xml.bind.annotation.XmlRootElement;

//@XmlRootElement  //Solo para el caso de usar "xml"
public class Curso {
  private Long id;

  private String name;

  private String description;

  private Instructor teacher;

  private Double duration;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Instructor getTeacher() {
    return teacher;
  }

  public void setTeacher(Instructor teacher) {
    this.teacher = teacher;
  }

  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Curso{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", teacher='" + teacher + '\'' +
            ", duration=" + duration +
            '}';
  }
}
