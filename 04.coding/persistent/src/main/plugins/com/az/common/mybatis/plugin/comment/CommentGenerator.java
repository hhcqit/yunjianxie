package com.az.common.mybatis.plugin.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 生成数据库字段注释 类名前加自定义注释 注释增加数据字段是否为必填项 注释增加数据字段是否有默认值 注释增加属性是否为主健
 */
public class CommentGenerator extends DefaultCommentGenerator {

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * @table "
				+ introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(" * @date "
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		topLevelClass.addJavaDocLine(" * @author jiff");
		topLevelClass.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		String remark = introspectedColumn.getRemarks();
		String columnName = introspectedColumn.getActualColumnName();
		List<IntrospectedColumn> primaryKey = introspectedTable
				.getPrimaryKeyColumns();
		for (IntrospectedColumn pk : primaryKey) {
			if (columnName.equals(pk.getActualColumnName())) {
				// remark += " (主健ID)";
				continue; // 主健属性上无需生明可选项跟必填项介绍
			}
			if (StringUtility.stringHasValue(remark)) {
				remark += introspectedColumn.isNullable() ? "(可选项)" : "(必填项)";
			}
		}
		String defaultValue = introspectedColumn.getDefaultValue();
		remark += null != defaultValue ? "  (默认值: " + defaultValue + ")" : "";
		field.addJavaDocLine("/** " + remark + " */");
	}

	public void addGetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		method.addJavaDocLine("/**");

		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		sb.setLength(0);
		sb.append(" * @return ");
		sb.append(introspectedColumn.getActualColumnName());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */");
	}

	public void addSetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		method.addJavaDocLine("/**");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parm.getName());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */");
	}

}