// DO NOT EDIT! This is a generated sample ("Callable",  "longrunning_recognize")
package com.google.cloud.examples.speech.v1.snippets;

// [START longrunning_recognize]
import com.google.cloud.speech.v1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.protobuf.ByteString;
import java.nio.Files;
import java.nio.Path;
import java.nio.Paths;

public class LongRunningRecognizeCallableCallableLongrunningRecognize {
  public static void sampleLongRunningRecognize() {
    // [START longrunning_recognize_core]
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionConfig config = RecognitionConfig.newBuilder().build();
      String fileName = "path/to/audio.wav";
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      ApiFuture<Operation> future = speechClient.longRunningRecognizeCallable().futureCall(request);

      // Do something

      Operation response = future.get();
      for (SpeechRecognitionAlternative alternative :
          response.getResultsList().get(0).getAlternativesList()) {
        System.out.printf("alternative: %s\n", alternative);
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END longrunning_recognize_core]
  }

  public static void main(String[] args) {
    sampleLongRunningRecognize();
  }
}
// FIXME: Insert here clean-up code.

// [END longrunning_recognize]
