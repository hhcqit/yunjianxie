package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EquipmentExamineSaveRequest
 */
@Validated

public class EquipmentExamineSaveRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("conclusion")
  private String conclusion = null;

  @JsonProperty("examineTime")
  private Date examineTime = null;

  @JsonProperty("examineItems")
  @Valid
  private List<EquipmentExamineItem> examineItems = null;

  public EquipmentExamineSaveRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 设备验收主键
   * @return id
  **/
  @ApiModelProperty(value = "设备验收主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EquipmentExamineSaveRequest equipId(Long equipId) {
    this.equipId = equipId;
    return this;
  }

   /**
   * 设备主键
   * @return equipId
  **/
  @ApiModelProperty(value = "设备主键")


  public Long getEquipId() {
    return equipId;
  }

  public void setEquipId(Long equipId) {
    this.equipId = equipId;
  }

  public EquipmentExamineSaveRequest reference(String reference) {
    this.reference = reference;
    return this;
  }

   /**
   * 验收依据
   * @return reference
  **/
  @ApiModelProperty(value = "验收依据")


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public EquipmentExamineSaveRequest conclusion(String conclusion) {
    this.conclusion = conclusion;
    return this;
  }

   /**
   * 验收结论
   * @return conclusion
  **/
  @ApiModelProperty(value = "验收结论")


  public String getConclusion() {
    return conclusion;
  }

  public void setConclusion(String conclusion) {
    this.conclusion = conclusion;
  }

  public EquipmentExamineSaveRequest examineTime(Date examineTime) {
    this.examineTime = examineTime;
    return this;
  }

   /**
   * 验收时间
   * @return examineTime
  **/
  @ApiModelProperty(value = "验收时间")

  @Valid

  public Date getExamineTime() {
    return examineTime;
  }

  public void setExamineTime(Date examineTime) {
    this.examineTime = examineTime;
  }

  public EquipmentExamineSaveRequest examineItems(List<EquipmentExamineItem> examineItems) {
    this.examineItems = examineItems;
    return this;
  }

  public EquipmentExamineSaveRequest addExamineItemsItem(EquipmentExamineItem examineItemsItem) {
    if (this.examineItems == null) {
      this.examineItems = new ArrayList<EquipmentExamineItem>();
    }
    this.examineItems.add(examineItemsItem);
    return this;
  }

   /**
   * Get examineItems
   * @return examineItems
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EquipmentExamineItem> getExamineItems() {
    return examineItems;
  }

  public void setExamineItems(List<EquipmentExamineItem> examineItems) {
    this.examineItems = examineItems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentExamineSaveRequest equipmentExamineSaveRequest = (EquipmentExamineSaveRequest) o;
    return Objects.equals(this.id, equipmentExamineSaveRequest.id) &&
        Objects.equals(this.equipId, equipmentExamineSaveRequest.equipId) &&
        Objects.equals(this.reference, equipmentExamineSaveRequest.reference) &&
        Objects.equals(this.conclusion, equipmentExamineSaveRequest.conclusion) &&
        Objects.equals(this.examineTime, equipmentExamineSaveRequest.examineTime) &&
        Objects.equals(this.examineItems, equipmentExamineSaveRequest.examineItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, equipId, reference, conclusion, examineTime, examineItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentExamineSaveRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
    sb.append("    examineTime: ").append(toIndentedString(examineTime)).append("\n");
    sb.append("    examineItems: ").append(toIndentedString(examineItems)).append("\n");
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

