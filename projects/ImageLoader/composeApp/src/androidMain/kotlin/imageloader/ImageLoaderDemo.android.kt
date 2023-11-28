package imageloader

import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.defaultImageResultMemoryCache
import com.seiko.imageloader.option.androidContext
import jp.kaleidot725.imageloader.MainActivity

actual fun generateImageLoader(): ImageLoader {
    return ImageLoader {
        options {
            androidContext(MainActivity.latestApplicationContext)
        }
        components {
            setupDefaultComponents()
        }
        interceptor {
            defaultImageResultMemoryCache()
            diskCacheConfig {
                maxSizeBytes(0)
            }
            memoryCacheConfig {
                maxSizeBytes(0)
            }
        }
    }
}