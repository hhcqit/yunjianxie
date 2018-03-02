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
 * TaskDeleteRequest
 */
@Validated

public class TaskDeleteRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("ids")
  private String ids = null;

  public TaskDeleteRequest ids(String ids) {
    this.ids = ids;
    return this;
  }

   /**
   * 主键列表
   * @return ids
  **/
  @ApiModelProperty(example = "1,2", value = "主键列表")


  public String getIds() {
    return ids;
  }

  public void setIds(String ids) {
    this.ids = ids;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDeleteRequest taskDeleteRequest = (TaskDeleteRequest) o;
    return Objects.equals(this.ids, taskDeleteRequest.ids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDeleteRequest {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
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

