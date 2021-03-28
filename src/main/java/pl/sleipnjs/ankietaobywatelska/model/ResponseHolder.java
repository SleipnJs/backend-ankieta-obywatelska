package pl.sleipnjs.ankietaobywatelska.model;

import java.util.Map;

public class ResponseHolder {
  String imageHref;
  Map<String, Object> responses;

  public ResponseHolder(String imageHref, Map<String, Object> responses) {
    this.imageHref = imageHref;
    this.responses = responses;
  }

  public String getImageHref() {
    return imageHref;
  }

  public void setImageHref(String imageHref) {
    this.imageHref = imageHref;
  }

  public void setResponses(Map<String, Object> responses) {
    this.responses = responses;
  }

  public Map<String, Object> getResponses() {
    return responses;
  }
}
