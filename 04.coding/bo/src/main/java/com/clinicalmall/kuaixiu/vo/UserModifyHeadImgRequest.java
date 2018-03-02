package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserModifyHeadImgRequest
 */
@Validated

public class UserModifyHeadImgRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("headImg")
  private String headImg = null;

  public UserModifyHeadImgRequest headImg(String headImg) {
    this.headImg = headImg;
    return this;
  }

   /**
   * 头像
   * @return headImg
  **/
  @ApiModelProperty(value = "头像")


  public String getHeadImg() {
    return headImg;
  }

  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserModifyHeadImgRequest userModifyHeadImgRequest = (UserModifyHeadImgRequest) o;
    return Objects.equals(this.headImg, userModifyHeadImgRequest.headImg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headImg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserModifyHeadImgRequest {\n");
    
    sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

