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
 * GetTaskByTaskNoRequest
 */
@Validated

public class GetTaskByTaskNoRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("taskNo")
  private String taskNo = null;

  public GetTaskByTaskNoRequest taskNo(String taskNo) {
    this.taskNo = taskNo;
    return this;
  }

   /**
   * 任务单号
   * @return taskNo
  **/
  @ApiModelProperty(example = "2018010100000001", value = "任务单号")


  public String getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTaskByTaskNoRequest getTaskByTaskNoRequest = (GetTaskByTaskNoRequest) o;
    return Objects.equals(this.taskNo, getTaskByTaskNoRequest.taskNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTaskByTaskNoRequest {\n");
    
    sb.append("    taskNo: ").append(toIndentedString(taskNo)).append("\n");
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

