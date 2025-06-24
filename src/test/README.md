# Contributing to z4j

Thank you for contributing to z4j!

This document provides guidelines for contributing z4j's automated testing

## Testing

Testing for z4j is composed of tests that run against a live Zendesk Help Center instance. This ensures that the generated client is compliant with the actual Zendesk API behavior. We don't provide a dedicated zendesk instance, it's up to you to provide that however you'd like to. 

### Prerequisites

To run the tests, you will need:

1. A Zendesk account with the Help Center activated, along with an API token for access.
2. Users with [different roles](#Required-Roles-for-Testing) created in your Zendesk instance.
3. [Environment variables](#Required-Environment-Variables) configured in your test environment

## Environment Setup

Tests require several environment variables to be configured to connect to your Zendesk instance and authenticate as different users.

### Required Roles for Testing

You'll need to set up the following users in your Zendesk account:

* A **Help Center Manager**: This user has administrative privileges in the Help Center.
* An **Agent**: A standard agent user.
* An **End-user**: A standard customer/end-user.

### Required Environment Variables

After setting up your [users](#Required-Roles-for-Testing) and token, export the following environment variables:

* `Z4J_URL`: The full URL of your Zendesk instance.
* `Z4J_TOKEN` : The API token for your Zendesk instance.
    * Example: `https://your-subdomain.zendesk.com`
* `Z4J_MANAGER_EMAIL`: The email address of your Help Center Manager user.
* `Z4J_AGENT_EMAIL`: The email address of your Agent user.
* `Z4J_ENDUSER_EMAIL`: The email address of your End-user.

## Running Tests

Once your environment is configured, you can run the entire test suite using the Gradle wrapper:This will execute all unit and integration tests.Writing TestsWe love to see new tests that increase our coverage and verify the client's behavior against more Zendesk API endpoints!Test FrameworkTests are written using the Spock Framework, and they are located in src/test/groovy/. Spock uses Groovy, which makes tests highly readable and expressive.Test StructureTests are typically structured as Spock Specification classes. For an example, see UserSegmentsClientSpec.groovy. These are @MicronautTests, which start up a Micronaut application context and allow for dependency injection of your API clients.This will execute all unit and integration tests.