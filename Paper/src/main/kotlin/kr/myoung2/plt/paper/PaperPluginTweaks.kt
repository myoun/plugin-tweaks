package kr.myoung2.plt.paper

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.Tag
import org.bukkit.inventory.*
import org.bukkit.plugin.java.JavaPlugin

class PaperPluginTweaks : JavaPlugin() {

    override fun onEnable() {
        registerRecipes()
    }


    fun registerRecipes() {
        // Make Recipe Variables
        val exp_bottle = ShapelessRecipe(NamespacedKey(this,"exp_bottle"), ItemStack(Material.EXPERIENCE_BOTTLE,1))
            .addIngredient(Material.GLASS_BOTTLE)
            .addIngredient(Material.ENCHANTED_BOOK)
            .addIngredient(Material.LAPIS_LAZULI)
        val bell = ShapedRecipe(NamespacedKey(this,"bell"), ItemStack(Material.BELL)).shape("gwg","ggg"," w ")
            .setIngredient('g',Material.GOLD_INGOT).setIngredient('w',RecipeChoice.MaterialChoice(Tag.PLANKS))
        val saddle = ShapedRecipe(NamespacedKey(this,"saddle"), ItemStack(Material.SADDLE))
            .shape("lll","l l","").setIngredient('l',Material.LEATHER)
        val totem = ShapedRecipe(NamespacedKey(this,"totem"), ItemStack(Material.TOTEM_OF_UNDYING))
            .shape("ege","ggg"," g ").setIngredient('e',Material.EMERALD_BLOCK).setIngredient('g',Material.GOLD_BLOCK)
        val trident = ShapedRecipe(NamespacedKey(this,"trident"), ItemStack(Material.TRIDENT))
            .shape("qqq"," d "," d ").setIngredient('q',Material.QUARTZ).setIngredient('d',Material.DIAMOND)
        val enchanted_apple = ShapedRecipe(NamespacedKey(this,"enchanted_apple"),
            ItemStack(Material.ENCHANTED_GOLDEN_APPLE)
        ).shape("lgl","gag","ggg").setIngredient('l',Material.LAPIS_BLOCK).setIngredient('g',Material.GOLD_BLOCK).setIngredient('a',Material.APPLE)
        val elytra = ShapedRecipe(NamespacedKey(this,"elytra"), ItemStack(Material.ELYTRA))
            .shape("psp","psp","fsf").setIngredient('p',ItemStack(Material.PHANTOM_MEMBRANE,4))
            .setIngredient('s', ItemStack(Material.SHULKER_SHELL,2)).setIngredient('f',
                ItemStack(Material.FEATHER,32)
            )
        val nametag = ShapelessRecipe(NamespacedKey(this,"nametag"), ItemStack(Material.NAME_TAG))
            .addIngredient(2,Material.PAPER).addIngredient(Material.INK_SAC)
        val spider_web = ShapelessRecipe(NamespacedKey(this,"spider_web"), ItemStack(Material.COBWEB))
            .addIngredient(4,Material.STRING)
        val sponge = ShapedRecipe(NamespacedKey(this,"sponge"), ItemStack(Material.SPONGE)).shape("www","wmw","www")
            .setIngredient('w',RecipeChoice.MaterialChoice(Tag.WOOL)).setIngredient('m',Material.MAGMA_BLOCK)

        addRecipes(exp_bottle,bell,saddle,totem,trident,enchanted_apple,elytra,nametag,spider_web,sponge)
    }

    private fun addRecipes(vararg recipes : Recipe) {
        recipes.forEach {
            server.addRecipe(it)
        }
    }
}

