Python Client for Google Cloud Natural Language API (`Alpha`_)
==============================================================

`Google Cloud Natural Language API`_: Google Cloud Natural Language API provides natural language understanding technologies to developers. Examples include sentiment analysis, entity recognition, and text annotations.

- `Client Library Documentation`_
- `Product Documentation`_

.. _Alpha: https://github.com/GoogleCloudPlatform/google-cloud-python/blob/master/README.rst
.. _Google Cloud Natural Language API: https://cloud.google.com/language
.. _Client Library Documentation: https://googlecloudplatform.github.io/google-cloud-python/latest/language/usage.html
.. _Product Documentation:  https://cloud.google.com/language

Quick Start
-----------

In order to use this library, you first need to go through the following steps:

1. `Select or create a Cloud Platform project.`_
2. `Enable billing for your project.`_
3. `Enable the Google Cloud Natural Language API.`_
4. `Setup Authentication.`_

.. _Select or create a Cloud Platform project.: https://console.cloud.google.com/project
.. _Enable billing for your project.: https://cloud.google.com/billing/docs/how-to/modify-project#enable_billing_for_a_project
.. _Enable the Google Cloud Natural Language API.:  https://cloud.google.com/language
.. _Setup Authentication.: https://googlecloudplatform.github.io/google-cloud-python/latest/core/auth.html

Installation
~~~~~~~~~~~~

Install this library in a `virtualenv`_ using pip. `virtualenv`_ is a tool to
create isolated Python environments. The basic problem it addresses is one of
dependencies and versions, and indirectly permissions.

With `virtualenv`_, it's possible to install this library without needing system
install permissions, and without clashing with the installed system
dependencies.

.. _`virtualenv`: https://virtualenv.pypa.io/en/latest/


Mac/Linux
^^^^^^^^^

.. code-block:: console

    pip install virtualenv
    virtualenv <your-env>
    source <your-env>/bin/activate
    <your-env>/bin/pip install google-cloud-language


Windows
^^^^^^^

.. code-block:: console

    pip install virtualenv
    virtualenv <your-env>
    <your-env>\Scripts\activate
    <your-env>\Scripts\pip.exe install google-cloud-language

Preview
~~~~~~~

LanguageServiceClient
^^^^^^^^^^^^^^^^^^^^^

.. code:: py

    from google.cloud import language_v1

    client = language_v1.LanguageServiceClient()

    # TODO: Initialize `document`:
    document = {}

    response = client.analyze_sentiment(document)

Next Steps
~~~~~~~~~~

-  Read the `Client Library Documentation`_ for Google Cloud Natural Language API
   API to see other available methods on the client.
-  Read the `Google Cloud Natural Language API Product documentation`_ to learn
   more about the product and see How-to Guides.
-  View this `repository’s main README`_ to see the full list of Cloud
   APIs that we cover.

.. _Google Cloud Natural Language API Product documentation:  https://cloud.google.com/language
.. _repository’s main README: https://github.com/GoogleCloudPlatform/google-cloud-python/blob/master/README.rst