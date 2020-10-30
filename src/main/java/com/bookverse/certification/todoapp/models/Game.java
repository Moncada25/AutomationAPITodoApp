package com.bookverse.certification.todoapp.models;

public class Game {

  private String id;
  private String title;
  private String description;
  private String image;
  private String createdAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {

    String result = "\nGame{\n";
    result += "   id: " + id + ",\n";
    result += "   title: " + title + ",\n";
    result += "   description: " + description + ",\n";
    result += "   image: " + image + ",\n";
    result += "   created_at: " + createdAt + "\n";
    result += "}";

    return result;
  }
}
