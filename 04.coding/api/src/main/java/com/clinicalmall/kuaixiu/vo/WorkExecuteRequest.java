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
 * WorkExecuteRequest
 */
@Validated

public class WorkExecuteRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("result")
  private String result = null;

  @JsonProperty("certificateNo")
  private String certificateNo = null;

  @JsonProperty("certificateFile")
  private String certificateFile = null;

  @JsonProperty("attachmentIds")
  private String attachmentIds = null;

  public WorkExecuteRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 作业主键
   * @return id
  **/
  @ApiModelProperty(value = "作业主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WorkExecuteRequest result(String result) {
    this.result = result;
    return this;
  }

   /**
   * 执行结果，可以是保养说明也可以是检定结论
   * @return result
  **/
  @ApiModelProperty(example = "月底保养", value = "执行结果，可以是保养说明也可以是检定结论")


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public WorkExecuteRequest certificateNo(String certificateNo) {
    this.certificateNo = certificateNo;
    return this;
  }

   /**
   * 证书编号
   * @return certificateNo
  **/
  @ApiModelProperty(example = "20180101", value = "证书编号")


  public String getCertificateNo() {
    return certificateNo;
  }

  public void setCertificateNo(String certificateNo) {
    this.certificateNo = certificateNo;
  }

  public WorkExecuteRequest certificateFile(String certificateFile) {
    this.certificateFile = certificateFile;
    return this;
  }

   /**
   * 证书文件名称
   * @return certificateFile
  **/
  @ApiModelProperty(example = "20180101", value = "证书文件名称")


  public String getCertificateFile() {
    return certificateFile;
  }

  public void setCertificateFile(String certificateFile) {
    this.certificateFile = certificateFile;
  }

  public WorkExecuteRequest attachmentIds(String attachmentIds) {
    this.attachmentIds = attachmentIds;
    return this;
  }

   /**
   * 附件主键列表,格式：id1,id2,...
   * @return attachmentIds
  **/
  @ApiModelProperty(example = "1,2", value = "附件主键列表,格式：id1,id2,...")


  public String getAttachmentIds() {
    return attachmentIds;
  }

  public void setAttachmentIds(String attachmentIds) {
    this.attachmentIds = attachmentIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkExecuteRequest workExecuteRequest = (WorkExecuteRequest) o;
    return Objects.equals(this.id, workExecuteRequest.id) &&
        Objects.equals(this.result, workExecuteRequest.result) &&
        Objects.equals(this.certificateNo, workExecuteRequest.certificateNo) &&
        Objects.equals(this.certificateFile, workExecuteRequest.certificateFile) &&
        Objects.equals(this.attachmentIds, workExecuteRequest.attachmentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, result, certificateNo, certificateFile, attachmentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkExecuteRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    certificateNo: ").append(toIndentedString(certificateNo)).append("\n");
    sb.append("    certificateFile: ").append(toIndentedString(certificateFile)).append("\n");
    sb.append("    attachmentIds: ").append(toIndentedString(attachmentIds)).append("\n");
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

