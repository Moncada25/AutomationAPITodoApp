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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  @Override
  public String toString() {

    String result = "\nGame{\n";
    result += "   id: "+id+",\n";
    result += "   title: "+title+",\n";
    result += "   description: "+description+",\n";
    result += "   image: "+image+",\n";
    result += "   created_at: "+created_at+"\n";
    result += "}";

    return result;
  }
}
