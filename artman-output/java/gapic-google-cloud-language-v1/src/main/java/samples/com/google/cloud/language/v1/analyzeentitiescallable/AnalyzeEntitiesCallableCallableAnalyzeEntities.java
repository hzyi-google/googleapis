// DO NOT EDIT! This is a generated sample ("Callable",  "analyze_entities")
package com.google.cloud.examples.language.v1.snippets;

// [START analyze_entities]
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;

public class AnalyzeEntitiesCallableCallableAnalyzeEntities {
  public static void sampleAnalyzeEntities() {
    // [START analyze_entities_core]
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      Document.Type type = Document.Type.PLAIN_TEXT;
      String content = "Your text to analyze, e.g. Hello, world!";
      Document document = Document.newBuilder().setType(type).setContent(content).build();
      EncodingType encodingType = EncodingType.NONE;
      AnalyzeEntitiesRequest request =
          AnalyzeEntitiesRequest.newBuilder()
              .setDocument(document)
              .setEncodingType(encodingType)
              .build();
      ApiFuture<AnalyzeEntitiesResponse> future =
          languageServiceClient.analyzeEntitiesCallable().futureCall(request);

      // Do something

      AnalyzeEntitiesResponse response = future.get();
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("entity: %s\n", entity);
      }
      String lang = response.getLanguage();
      System.out.printf("language in the response: %s\n", lang);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END analyze_entities_core]
  }

  public static void main(String[] args) {
    sampleAnalyzeEntities();
  }
}
// FIXME: Insert here clean-up code.

// [END analyze_entities]
