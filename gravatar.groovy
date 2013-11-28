import java.io.*
import java.util.*
import java.security.*

class GravatarPlugin {
    def config

    def setupBinding(binding) {
        binding.gravatar = { email, size ->
            if (size == null)
                size = 250
            """<img src="http://www.gravatar.com/avatar/${md5Hex(email)}?s=${size}" />"""
        }
    }

    def md5Hex = { message -> 
        try {
            def md = MessageDigest.getInstance("MD5")
            return hex(md.digest(message.getBytes("CP1252")))
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        null
    }

    def hex = { array -> 
        def sb = new StringBuffer()
        for (b in array)
            sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3))
        sb.toString()
    }
}