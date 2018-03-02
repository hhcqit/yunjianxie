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
 * OrgBindRequest
 */
@Validated

public class OrgBindRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("relateOrgId")
  private Long relateOrgId = null;

  public OrgBindRequest relateOrgId(Long relateOrgId) {
    this.relateOrgId = relateOrgId;
    return this;
  }

   /**
   * 主键
   * @return relateOrgId
  **/
  @ApiModelProperty(value = "主键")


  public Long getRelateOrgId() {
    return relateOrgId;
  }

  public void setRelateOrgId(Long relateOrgId) {
    this.relateOrgId = relateOrgId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgBindRequest orgBindRequest = (OrgBindRequest) o;
    return Objects.equals(this.relateOrgId, orgBindRequest.relateOrgId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relateOrgId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgBindRequest {\n");
    
    sb.append("    relateOrgId: ").append(toIndentedString(relateOrgId)).append("\n");
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

