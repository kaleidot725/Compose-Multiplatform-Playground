package imageloader

import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.defaultImageResultMemoryCache

actual fun generateImageLoader(): ImageLoader {
    return ImageLoader {
        components {
            setupDefaultComponents()
        }
        interceptor {
            diskCacheConfig {
                maxSizeBytes(0)
            }
            memoryCacheConfig {
                maxSizeBytes(0)
            }
        }
    }
}