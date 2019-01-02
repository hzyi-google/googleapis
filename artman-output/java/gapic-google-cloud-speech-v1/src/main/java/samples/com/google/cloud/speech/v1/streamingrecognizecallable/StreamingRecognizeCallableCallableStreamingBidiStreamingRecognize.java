// DO NOT EDIT! This is a generated sample ("CallableStreamingBidi",  "streaming_recognize")
package com.google.cloud.examples.speech.v1.snippets;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
// [START streaming_recognize]
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.protobuf.ByteString;
import java.nio.File;
import java.nio.Files;
import java.nio.Path;
import java.nio.Paths;

public class StreamingRecognizeCallableCallableStreamingBidiStreamingRecognize {
  public static void sampleStreamingRecognize(String audioContentFileName) {
    // [START streaming_recognize_core]
    try (SpeechClient speechClient = SpeechClient.create()) {
      BidiStream<StreamingRecognizeRequest, StreamingRecognizeResponse> bidiStream =
          speechClient.streamingRecognizeCallable().call();

      // String audioContentFileName = "path/to/audio.wav";
      Path path = Paths.get(audioContentFileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioContent = ByteString.copyFrom(data);
      StreamingRecognizeRequest request = StreamingRecognizeRequest.newBuilder()
        .setAudioContent(audioContent)
        .build();
      bidiStream.send(request);
      for (StreamingRecognizeResponse responseItem : bidiStream) {
        for (SpeechRecognitionAlternative alternative : responseItem.getResultsList().get(0).getAlternativesList()) {
          SpeechRecognitionAlternative alt = alternative;
          System.out.printf("alternative: %s\n", alt);
        }
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END streaming_recognize_core]
  }

  public static void main(String[] args) {
    Options options = new Options();
    options.addOption(
        Option.builder("")
          .required(false)
          .hasArg(true)
          .longOpt("audioContentFileName")
          .build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String audioContentFileName = cl.getOptionValue("audioContentFileName", "path/to/audio.wav");

    sampleStreamingRecognize(audioContentFileName);
  }
}
// FIXME: Insert here clean-up code.

// [END streaming_recognize]