package com.eerussianguy.decay_2012.client;

import java.util.function.Function;

import net.minecraftforge.common.ForgeConfigSpec;

import net.dries007.tfc.config.FoodExpiryTooltipStyle;

import static net.dries007.tfc.TerraFirmaCraft.MOD_ID;

public class DecayClientConfig
{
    public final ForgeConfigSpec.EnumValue<FoodExpiryTooltipStyle> foodExpiryTooltipStyle;
    public final ForgeConfigSpec.BooleanValue enableFoodShowsStackCount;
    public final ForgeConfigSpec.IntValue maxOunces;
    public final ForgeConfigSpec.BooleanValue enableFoodWeightRender;
    public final ForgeConfigSpec.BooleanValue enableFoodDecayRender;
    public final ForgeConfigSpec.BooleanValue enableEuropeanMode;

    public DecayClientConfig(ForgeConfigSpec.Builder innerBuilder)
    {
        Function<String, ForgeConfigSpec.Builder> builder = name -> innerBuilder.translation(MOD_ID + ".config.client." + name);

        innerBuilder.push("general");
        foodExpiryTooltipStyle = builder.apply("foodExpiryTooltipStyle").comment("(THIS OPTION ALWAYS OVERRIDES THE TFC OPTION) Food expiry tooltip display style. This affects what information is shown on the food item stack tooltips.", "NONE - Shows nothing. Maximum mystery!", "EXPIRY - e.g. 'Expires on June 3, 05:00", "TIME_LEFT - e.g. 'Expires in about 3 day(s)", "BOTH - Shows both of the above, e.g. Expires on June 3, 05:00 (in about 3 day(s)).").defineEnum("foodExpiryTooltipStyle", FoodExpiryTooltipStyle.NONE);
        enableFoodShowsStackCount = builder.apply("enableFoodShowsStackCount").comment("If true, food stack counts will render behind the weight bar").define("enableFoodShowsStackCount", false);
        maxOunces = builder.apply("maxOunces").comment("The value that should be displayed as the maximum ounces (or whatever kind of weight type you choose) a food item could weigh. By default, a full stack is 160 ounces.").defineInRange("maxOunces", 16, 1, Integer.MAX_VALUE);
        enableFoodWeightRender = builder.apply("enableFoodWeightRender").comment("Enable rendering a food weight bar").define("enableFoodWeightRender", true);
        enableFoodDecayRender = builder.apply("enableFoodDecayRender").comment("Enable rendering a food weight bar").define("enableFoodDecayRender", true);
        enableEuropeanMode = builder.apply("enableEuropeanMode").comment("If true, SI units will be used for food weight instead of the traditional oz. The name of this config option is a joke, I know SI units are used outside of Europe.").define("enableEuropeanMode", false);

        innerBuilder.pop();
    }
}
