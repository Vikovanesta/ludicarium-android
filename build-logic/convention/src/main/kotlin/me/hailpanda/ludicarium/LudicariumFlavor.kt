package me.hailpanda.ludicarium

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType
}

// The content for the app can either come from local static data which is useful for demo
// purposes, or from a production backend server which supplies up-to-date, real content.
// These two product flavors reflect this behaviour.
@Suppress("EnumEntryName")
enum class LudicariumFlavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    demo(FlavorDimension.contentType, applicationIdSuffix = ".demo"),
    prod(FlavorDimension.contentType)
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: LudicariumFlavor) -> Unit = {}
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.contentType.name
        productFlavors {
            LudicariumFlavor.values().forEach { ludicariumFlavor ->
                val flavor = create(ludicariumFlavor.name)
                configureFlavor(flavor, ludicariumFlavor, flavorConfigurationBlock)
            }
        }
    }
}

private fun configureFlavor(
    flavor: ProductFlavor,
    ludicariumFlavor: LudicariumFlavor,
    flavorConfigurationBlock: ProductFlavor.(flavor: LudicariumFlavor) -> Unit
) {
    flavor.dimension = ludicariumFlavor.dimension.name
    flavorConfigurationBlock(flavor, ludicariumFlavor)
    if (flavor is ApplicationExtension && flavor is ApplicationProductFlavor) {
        if (ludicariumFlavor.applicationIdSuffix != null) {
            flavor.applicationIdSuffix = ludicariumFlavor.applicationIdSuffix
        }
    }
}

