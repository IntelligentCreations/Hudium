<img src="nice_pic.png" width="960" height="504" alt="nice pic hahaye"/>

# Hudium

*Roughly enough HUD tweaks*

[![](https://jitpack.io/v/IntelligentCreations/Hudium.svg)](https://jitpack.io/#IntelligentCreations/Hudium)

This mod adds tons of HUD tweaks including player stats, block/entity info, etc. Everything can be toggled via the config.

### Setting up development environment

Add this to your build.gradle:
```groovy
repositories {
	// [...]
	maven { url 'https://jitpack.io' }
}

dependencies {
	// [...]
	modImplementation "com.github.IntelligentCreations:Hudium:${project.hudium_version}"
}
```

And in your gradle.properties:
```properties
hudium_version = <LATEST_VERSION>
```

### Developing with Hudium

Go have a look at the [wiki](https://github.com/IntelligentCreations/Hudium/wiki).
