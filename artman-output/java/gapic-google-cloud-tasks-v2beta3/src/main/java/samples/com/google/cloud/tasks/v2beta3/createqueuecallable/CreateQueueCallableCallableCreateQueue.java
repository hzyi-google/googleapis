// DO NOT EDIT! This is a generated sample ("Callable",  "create_queue")
package com.google.cloud.examples.tasks.v2beta3.snippets;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
// [START create_queue]
import com.google.cloud.tasks.v2beta3.CloudTasksClient;
import com.google.cloud.tasks.v2beta3.CreateQueueRequest;
import com.google.cloud.tasks.v2beta3.LocationName;
import com.google.cloud.tasks.v2beta3.Queue;

public class CreateQueueCallableCallableCreateQueue {
  public static void sampleCreateQueue(String locationOfTheQueue, String locationId) {
    // [START create_queue_core]
    try (CloudTasksClient cloudTasksClient = CloudTasksClient.create()) {
      // String locationOfTheQueue = " my_location";
      // String locationId = " my_location";
      LocationName parent = LocationName.of( "my_project_name", locationId);
      String formattedName = CloudTasksClient.formatQueueName( my_project, locationOfTheQueue,  my_queue);
      Queue queue = Queue.newBuilder()
        .setName(formattedName)
        .build();
      CreateQueueRequest request = CreateQueueRequest.newBuilder()
        .setParent(parent.toString())
        .setQueue(queue)
        .build();
      ApiFuture<Queue> future = cloudTasksClient.createQueueCallable().futureCall(request);

      // Do something

      Queue response = future.get();
      System.out.println(response);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END create_queue_core]
  }

  public static void main(String[] args) {
    Options options = new Options();
    options.addOption(
        Option.builder("")
          .required(false)
          .hasArg(true)
          .longOpt("locationOfTheQueue")
          .build());
    options.addOption(
        Option.builder("")
          .required(false)
          .hasArg(true)
          .longOpt("locationId")
          .build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String locationOfTheQueue = cl.getOptionValue("locationOfTheQueue", " my_location");
    String locationId = cl.getOptionValue("locationId", " my_location");

    sampleCreateQueue(locationOfTheQueue, locationId);
  }
}
// FIXME: Insert here clean-up code.

// [END create_queue]