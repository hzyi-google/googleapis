// DO NOT EDIT! This is a generated sample ("Request",  "annotate_text")
package com.google.cloud.examples.language.v1.snippets;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
// [START annotate_text]
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextRequest.Features;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;

public class AnnotateTextRequestAnnotateText {
  public static void sampleAnnotateText(boolean shouldExtractSyntaxInfo, boolean extractEntities) {
    // [START annotate_text_core]
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      // boolean shouldExtractSyntaxInfo = true;
      // boolean extractEntities = true;
      Document.Type type = Document.Type.PLAIN_TEXT;
      String content = "Your text to analyze, e.g. Hello, world!";
      Document document = Document.newBuilder()
        .setType(type)
        .setContent(content)
        .build();
      AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder()
        .setExtractSyntax(shouldExtractSyntaxInfo)
        .setExtractEntities(extractEntities)
        .build();
      EncodingType encodingType = EncodingType.NONE;
      AnnotateTextRequest request = AnnotateTextRequest.newBuilder()
        .setDocument(document)
        .setFeatures(features)
        .setEncodingType(encodingType)
        .build();
      AnnotateTextResponse response = languageServiceClient.annotateText(request);
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("entity: %s\n", entity);
      }
      String lang = response.getLanguage();
      System.out.printf("language in the response: %s\n", lang);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END annotate_text_core]
  }

  public static void main(String[] args) {
    Options options = new Options();
    options.addOption(
        Option.builder("")
          .required(false)
          .hasArg(true)
          .longOpt("shouldExtractSyntaxInfo")
          .build());
    options.addOption(
        Option.builder("")
          .required(false)
          .hasArg(true)
          .longOpt("extractEntities")
          .build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    boolean shouldExtractSyntaxInfo =
        cl.getOptionValue("shouldExtractSyntaxInfo") != null
            ? Boolean.parseBoolean(cl.getOptionValue("shouldExtractSyntaxInfo"))
            : true;
    boolean extractEntities =
        cl.getOptionValue("extractEntities") != null
            ? Boolean.parseBoolean(cl.getOptionValue("extractEntities"))
            : true;

    sampleAnnotateText(shouldExtractSyntaxInfo, extractEntities);
  }
}
// FIXME: Insert here clean-up code.

// [END annotate_text]