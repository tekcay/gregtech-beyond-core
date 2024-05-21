package gtb.api.recipes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.RecipePropertyStorage;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import gregtech.api.util.ValidationResult;

import gtb.api.recipes.properties.KevInputRecipeProperty;
import gtb.api.recipes.properties.RecipePropertiesKey;

public class EuKevRecipeBuilder extends RecipeBuilder<EuKevRecipeBuilder> {

    @SuppressWarnings("unused")
    public EuKevRecipeBuilder() {}

    @SuppressWarnings("unused")
    public EuKevRecipeBuilder(Recipe recipe, RecipeMap<EuKevRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public EuKevRecipeBuilder(EuKevRecipeBuilder builder) {
        super(builder);
    }

    @Override
    public EuKevRecipeBuilder copy() {
        return new EuKevRecipeBuilder(this);
    }

    @NotNull
    public EuKevRecipeBuilder KeV(int kev) {
        if (kev <= 0) {
            GTLog.logger.error(RecipePropertiesKey.KEV + " cannot be less than or equal to 0",
                    new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(KevInputRecipeProperty.getInstance(), kev);
        return this;
    }

    @Override
    public ValidationResult<Recipe> build() {
        if (this.recipePropertyStorage == null) this.recipePropertyStorage = new RecipePropertyStorage();
        if (this.recipePropertyStorage.hasRecipeProperty(KevInputRecipeProperty.getInstance())) {
            if (this.recipePropertyStorage.getRecipePropertyValue(KevInputRecipeProperty.getInstance(), 0) <= 0) {
                this.recipePropertyStorage.store(KevInputRecipeProperty.getInstance(), 0);
            }
        } else {
            this.recipePropertyStorage.store(KevInputRecipeProperty.getInstance(), 0);
        }
        return super.build();
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(RecipePropertiesKey.KEV.name())) {
            this.KeV(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public int getKeV() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(KevInputRecipeProperty.getInstance(), 0);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("", getKeV())
                .toString();
    }
}
