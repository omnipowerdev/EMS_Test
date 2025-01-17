package io.openems.edge.goodwe.gridmeter;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.edge.goodwe.GoodWeConstants;

@ObjectClassDefinition(//
		name = "GoodWe Grid-Meter", //
		description = "GoodWe Smart Meter.")

@interface Config {
	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "meter0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Select the grid meter category.", description = "Select grid meter category (Commercial Meter only valid for ETT-Systems e.g. GoodWe 20/30)")
	GoodWeGridMeterCategory goodWeMeterCategory() default GoodWeGridMeterCategory.SMART_METER;

	@AttributeDefinition(name = "First CT-Ratio Value of external meter (Only for goodWeMeterCategory=COMMERCIAL_METER)", description = "First CT-Ratio Value(eg. \"200\":5 A) of external (eg. Commercial/Business) meter. (Available only for ETT-Systems)")
	int externalMeterRatioValueA() default 0;

	@AttributeDefinition(name = "Second CT-Ratio Value of external meter (Only for goodWeMeterCategory=COMMERCIAL_METER).", description = "Second CT-Ratio Value(eg. 200:\"5\" A) of external (eg. Commercial/Business) meter. (Available only for ETT-Systems)")
	int externalMeterRatioValueB() default 5;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus bridge.")
	String modbus_id() default "modbus0";

	@AttributeDefinition(name = "Modbus Unit-ID", description = "The Unit-ID of the Modbus device.")
	int modbusUnitId() default GoodWeConstants.DEFAULT_UNIT_ID;

	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "(enabled=true)";

	String webconsole_configurationFactory_nameHint() default "GoodWe Grid-Meter [{id}]";

}