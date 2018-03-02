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
 * SortField
 */
@Validated

public class SortField  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("fieldname")
  private String fieldname = null;

  @JsonProperty("fieldvalue")
  private String fieldvalue = null;

  public SortField fieldname(String fieldname) {
    this.fieldname = fieldname;
    return this;
  }

   /**
   * Get fieldname
   * @return fieldname
  **/
  @ApiModelProperty(value = "")


  public String getFieldname() {
    return fieldname;
  }

  public void setFieldname(String fieldname) {
    this.fieldname = fieldname;
  }

  public SortField fieldvalue(String fieldvalue) {
    this.fieldvalue = fieldvalue;
    return this;
  }

   /**
   * asc desc
   * @return fieldvalue
  **/
  @ApiModelProperty(value = "asc desc")


  public String getFieldvalue() {
    return fieldvalue;
  }

  public void setFieldvalue(String fieldvalue) {
    this.fieldvalue = fieldvalue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SortField sortField = (SortField) o;
    return Objects.equals(this.fieldname, sortField.fieldname) &&
        Objects.equals(this.fieldvalue, sortField.fieldvalue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldname, fieldvalue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SortField {\n");
    
    sb.append("    fieldname: ").append(toIndentedString(fieldname)).append("\n");
    sb.append("    fieldvalue: ").append(toIndentedString(fieldvalue)).append("\n");
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

