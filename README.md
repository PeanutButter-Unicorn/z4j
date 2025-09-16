<img src="src/main/docs/z4j.svg" width="300" alt="z4j logo">

# z4j

A Java client for the Zendesk API

## About The Project

`z4j` java client for the Zendesk API, built for Java 17+ with [Micronaut](https://micronaut.io/). It is designed to be [Ahead-of-Time (AOT) compiled](https://en.wikipedia.org/wiki/Ahead-of-time_compilation), resulting in quick performance and a low memory footprint.

## Advantages over Dynamic Language Clients

While Zendesk clients in dynamic languages like Python are excellent for scripting and rapid prototyping, `z4j` offers distinct advantages for building robust, high-performance applications:

*   **Type Safety:** `z4j` is type-safe, meaning the compiler catches API inconsistencies and data type errors at build time. This prevents a class of runtime errors common in dynamic languages, leading to more reliable applications.
*   **Performance and Efficiency:** Because `z4j` uses micronaut's AOT compilation, applications using z4j benefit from:
    *   **Faster Startup:** Quick Start time, a major advantage for microservices and serverless functions.
    *   **Lower Memory Footprint:** AOT-compiled applications use significantly less memory, reducing cloud hosting costs and allowing for more efficient resource utilization.

## Getting Started

To get a local copy up and running, please follow the detailed setup instructions in our 
[Contributing Guide](CONTRIBUTING.md#set-up-your-machine).

### Prerequisites

You will need a Java 17 installed locally (we recommend [GraalVM](https://www.graalvm.org/downloads/)).


## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any 
contributions you make are **greatly appreciated**.

Please read our [Code of Conduct](CODE_OF_CONDUCT.md) and [Contributing Guide](CONTRIBUTING.md) for details on our development process, style guides, and testing strategy.

## License

Distributed under the Apache License, Version 2.0. See `LICENSE` for more information.

## Acknowledgments
*   [Zendesk API Documentation](https://developer.zendesk.com/api-reference/)
*   [Micronaut OpenAPI](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/)
*   [Conventional Commits](https://www.conventionalcommits.org/)
*   [Contributor Covenant](https://www.contributor-covenant.org/)
