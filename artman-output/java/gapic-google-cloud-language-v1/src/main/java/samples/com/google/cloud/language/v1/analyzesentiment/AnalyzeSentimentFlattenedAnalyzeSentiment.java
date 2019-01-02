// DO NOT EDIT! This is a generated sample ("Flattened",  "analyze_sentiment")
package com.google.cloud.examples.language.v1.snippets;

// [START analyze_sentiment]
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;

public class AnalyzeSentimentFlattenedAnalyzeSentiment {
  public static void sampleAnalyzeSentiment() {
    // [START analyze_sentiment_core]
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      Document.Type type = Document.Type.PLAIN_TEXT;
      String content = "Your text to analyze, e.g. Hello, world!";
      Document document = Document.newBuilder().setType(type).setContent(content).build();
      AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
      System.out.println(response);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END analyze_sentiment_core]
  }

  public static void main(String[] args) {
    sampleAnalyzeSentiment();
  }
}
// FIXME: Insert here clean-up code.

// [END analyze_sentiment]
