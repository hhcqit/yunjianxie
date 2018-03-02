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
 * FilterField
 */
@Validated

public class FilterField  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("fieldname")
  private String fieldname = null;

  @JsonProperty("operator")
  private String operator = null;

  @JsonProperty("fieldvalue")
  private String fieldvalue = null;

  public FilterField fieldname(String fieldname) {
    this.fieldname = fieldname;
    return this;
  }

   /**
   * fieldname
   * @return fieldname
  **/
  @ApiModelProperty(example = "lastName", value = "fieldname")


  public String getFieldname() {
    return fieldname;
  }

  public void setFieldname(String fieldname) {
    this.fieldname = fieldname;
  }

  public FilterField operator(String operator) {
    this.operator = operator;
    return this;
  }

   /**
   * operator
   * @return operator
  **/
  @ApiModelProperty(example = "=", value = "operator")


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public FilterField fieldvalue(String fieldvalue) {
    this.fieldvalue = fieldvalue;
    return this;
  }

   /**
   * fieldvalue
   * @return fieldvalue
  **/
  @ApiModelProperty(example = "jiff", value = "fieldvalue")


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
    FilterField filterField = (FilterField) o;
    return Objects.equals(this.fieldname, filterField.fieldname) &&
        Objects.equals(this.operator, filterField.operator) &&
        Objects.equals(this.fieldvalue, filterField.fieldvalue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldname, operator, fieldvalue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterField {\n");
    
    sb.append("    fieldname: ").append(toIndentedString(fieldname)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
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

