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
 * TaskExamineRequest
 */
@Validated

public class TaskExamineRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("examineCalibrate")
  private String examineCalibrate = null;

  @JsonProperty("examineQc")
  private String examineQc = null;

  @JsonProperty("examineSample")
  private String examineSample = null;

  @JsonProperty("examineDescription")
  private String examineDescription = null;

  @JsonProperty("malfunctionDuration")
  private Integer malfunctionDuration = null;

  @JsonProperty("action")
  private String action = null;

  public TaskExamineRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务主键
   * @return id
  **/
  @ApiModelProperty(value = "任务主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskExamineRequest examineCalibrate(String examineCalibrate) {
    this.examineCalibrate = examineCalibrate;
    return this;
  }

   /**
   * 检定情况
   * @return examineCalibrate
  **/
  @ApiModelProperty(example = "正常", value = "检定情况")


  public String getExamineCalibrate() {
    return examineCalibrate;
  }

  public void setExamineCalibrate(String examineCalibrate) {
    this.examineCalibrate = examineCalibrate;
  }

  public TaskExamineRequest examineQc(String examineQc) {
    this.examineQc = examineQc;
    return this;
  }

   /**
   * 质控情况
   * @return examineQc
  **/
  @ApiModelProperty(example = "正常", value = "质控情况")


  public String getExamineQc() {
    return examineQc;
  }

  public void setExamineQc(String examineQc) {
    this.examineQc = examineQc;
  }

  public TaskExamineRequest examineSample(String examineSample) {
    this.examineSample = examineSample;
    return this;
  }

   /**
   * 留样情况
   * @return examineSample
  **/
  @ApiModelProperty(example = "正常", value = "留样情况")


  public String getExamineSample() {
    return examineSample;
  }

  public void setExamineSample(String examineSample) {
    this.examineSample = examineSample;
  }

  public TaskExamineRequest examineDescription(String examineDescription) {
    this.examineDescription = examineDescription;
    return this;
  }

   /**
   * 验收说明
   * @return examineDescription
  **/
  @ApiModelProperty(example = "正常", value = "验收说明")


  public String getExamineDescription() {
    return examineDescription;
  }

  public void setExamineDescription(String examineDescription) {
    this.examineDescription = examineDescription;
  }

  public TaskExamineRequest malfunctionDuration(Integer malfunctionDuration) {
    this.malfunctionDuration = malfunctionDuration;
    return this;
  }

   /**
   * 故障时长，单位小时
   * @return malfunctionDuration
  **/
  @ApiModelProperty(example = "1", value = "故障时长，单位小时")


  public Integer getMalfunctionDuration() {
    return malfunctionDuration;
  }

  public void setMalfunctionDuration(Integer malfunctionDuration) {
    this.malfunctionDuration = malfunctionDuration;
  }

  public TaskExamineRequest action(String action) {
    this.action = action;
    return this;
  }

   /**
   * 操作<br>0：拒绝  1：确认
   * @return action
  **/
  @ApiModelProperty(example = "1", value = "操作<br>0：拒绝  1：确认")


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskExamineRequest taskExamineRequest = (TaskExamineRequest) o;
    return Objects.equals(this.id, taskExamineRequest.id) &&
        Objects.equals(this.examineCalibrate, taskExamineRequest.examineCalibrate) &&
        Objects.equals(this.examineQc, taskExamineRequest.examineQc) &&
        Objects.equals(this.examineSample, taskExamineRequest.examineSample) &&
        Objects.equals(this.examineDescription, taskExamineRequest.examineDescription) &&
        Objects.equals(this.malfunctionDuration, taskExamineRequest.malfunctionDuration) &&
        Objects.equals(this.action, taskExamineRequest.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, examineCalibrate, examineQc, examineSample, examineDescription, malfunctionDuration, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskExamineRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    examineCalibrate: ").append(toIndentedString(examineCalibrate)).append("\n");
    sb.append("    examineQc: ").append(toIndentedString(examineQc)).append("\n");
    sb.append("    examineSample: ").append(toIndentedString(examineSample)).append("\n");
    sb.append("    examineDescription: ").append(toIndentedString(examineDescription)).append("\n");
    sb.append("    malfunctionDuration: ").append(toIndentedString(malfunctionDuration)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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

