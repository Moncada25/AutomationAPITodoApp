package com.bookverse.certification.packapps.models;

public class Game {

  private String id;
  private String title;
  private String description;
  private String image;
  private String created_at;

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

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  @Override
  public String toString() {

    String result = "\nGame{\n";
    result += "   id: " + id + ",\n";
    result += "   title: " + title + ",\n";
    result += "   description: " + description + ",\n";
    result += "   image: " + image + ",\n";
    result += "   created_at: " + created_at + "\n";
    result += "}";

    return result;
  }
}
