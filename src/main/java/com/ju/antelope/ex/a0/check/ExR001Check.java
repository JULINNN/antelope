package com.ju.antelope.ex.a0.check;

import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExR001Check {

  private static final String ALGORITHM = "HmacSHA256";

  @Value("${line.bot.channel-secret}")
  private String secretKey;

  /** 確認訊息是由line發布 */
  public boolean isVaildMsg(String requestBody, String signature) {
    try {
      SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
      Mac mac = Mac.getInstance(ALGORITHM);
      mac.init(key);
      byte[] source = requestBody.getBytes(StandardCharsets.UTF_8);
      String encodeSig = Base64.encodeBase64String(mac.doFinal(source));
      return encodeSig != null && encodeSig.equals(signature);
    } catch (Exception e) {
      return false;
    }
  }
}
