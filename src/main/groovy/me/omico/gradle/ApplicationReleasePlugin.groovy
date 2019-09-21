package me.omico.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationReleasePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.apply plugin: 'com.android.application'
        project.android {
            File propertiesFile = new File(project.rootProject.projectDir, 'release.properties')
            if (propertiesFile.exists()) {
                signingConfigs {
                    release {
                        Properties localProperties = new Properties()
                        localProperties.load(propertiesFile.newDataInputStream())
                        keyAlias localProperties['key.alias']
                        keyPassword localProperties['key.password']
                        storeFile new File(localProperties['store.file'] as String)
                        storePassword localProperties['store.password']
                    }
                }
                buildTypes {
                    release {
                        signingConfig signingConfigs.release
                    }
                }
            } else {
                logger.error('=============================================')
                logger.error('==== release.properties does not exists. ====')
                logger.error('=============================================')
            }
        }
    }
}
