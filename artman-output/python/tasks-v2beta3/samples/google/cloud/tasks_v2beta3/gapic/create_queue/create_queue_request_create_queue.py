# -*- coding: utf-8 -*-
#
# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# DO NOT EDIT! This is a generated sample ("Request",  "create_queue")

# To install the latest published package dependency, execute the following:
#   pip install google-cloud-tasks

import sys

# [START create_queue]

from google.cloud import tasks_v2beta3
import six


def sample_create_queue(location_of_the_queue, location_id):
    """Proof of concept for creating queues"""

    # [START create_queue_core]

    client = tasks_v2beta3.CloudTasksClient()

    # location_of_the_queue = ' my_location'
    # location_id = ' my_location'

    if isinstance(location_of_the_queue, six.binary_type):
        location_of_the_queue = location_of_the_queue.decode('utf-8')
    if isinstance(location_id, six.binary_type):
        location_id = location_id.decode('utf-8')
    parent = client.location_path("my_project_name", location_id)
    name = client.queue_path(my_project, location_of_the_queue, my_queue)
    queue = {'name': name}

    response = client.create_queue(parent, queue)
    print(response)

    # [END create_queue_core]


# [END create_queue]


def main():
    import argparse

    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--location_of_the_queue', type=str, default=' my_location')
    parser.add_argument('--location_id', type=str, default=' my_location')
    args = parser.parse_args()

    sample_create_queue(args.location_of_the_queue, args.location_id)


if __name__ == '__main__':
    main()
