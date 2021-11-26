# Java Data Visualization Library CJ-Plot

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)


Your README file is normally the first entry point to your code. It should tell people why they should use your module, how they can install it, and how they can use it. Standardizing how you write your README makes creating and maintaining your READMEs easier. Great documentation takes work!

This repository contains:

1. [The specification](spec.md) for how a standard README should look.
2. A link to [a linter](https://github.com/RichardLitt/standard-readme-preset) you can use to keep your README maintained ([work in progress](https://github.com/RichardLitt/standard-readme/issues/5)).
3. A link to [a generator](https://github.com/RichardLitt/generator-standard-readme) you can use to create standard READMEs.
4. [A badge](#badge) to point to this spec.
5. [Examples of standard READMEs](example-readmes/) - such as this file you are reading.

Standard Readme is designed for open source libraries. Although it’s [historically](#background) made for Node and npm projects, it also applies to libraries in other languages and package managers.


## Table of Contents

- [Background](#background)
- [Objectives](objectives)
- [Class-Structure](#class-structure)
- [Example](#example)
- [Badge](#badge)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Background
There are many plotting libraries for Python, Javascript, R and Matlab – some examples include 
Plotly and Mathplotlib . However, there are not many for Java. This project involves
developing 2D plotting libraries for use with Java. The idea would be able to 
create images in various formats that could be displayed and used in papers, Web pages etc. 
There are many different kinds of plots that could be created and many different visualization 
styles. The motivation for this would be to enable datasets being 
manipulated using java to visualized without the need to use other toolsets such as Python, R or 
Matlab.

## Objectives
Primary: (Mostly achieved)
- Provide a method that turns data into a format suitable for plotting. 
- Provide methods that return descriptive statistics, both for plotting charts and get 
statistical information, including mode, mean, median, sum, max, min, percentiles，
quantile variance, skewness, covariance, etc.
- Chart plotting
- Plot scatter, line, bar, box, column, pie, bubble and heat charts based on the input data
- Export chart in PNG format
- Function plotting
- Support for drawing elementary functions and composition of any of finite number of them, 
including constant functions, power functions, square root functions, exponential
functions, logarithms functions, trigonometric functions, inverse trigonometric functions 
and piecewise functions composed of elementary functions

Secondary:(On-going)
- Data pre-processing
- Support for trimming, merging, selecting and amending of tables.
- Generate a linear regression curve for input data sets.
- Chart plotting
- Support for changing the style of the chart, including but not limited to coordinate length 
and width, line/column colour, label size, point shape, background colour, font size.
- Support a combination of different charts or function charts.
- Support for drawing a 3-dimensional point-set graph based on the input point-set in 
three dimensions,
- Generate a smooth surface based on a 3-dimensional point set
- Support for controlling the size, colour, texture, transparency, display angle, etc. of the 
- Function plotting
- Plot statistical distribution function


## Class Structure

![1637890650(1)](https://user-images.githubusercontent.com/78740875/143514178-e497eda3-64bf-414e-bfac-9bc9456ba0ce.png)

## Example

This is only a documentation package. You can print out [spec.md](spec.md) to your console:

```sh
$ standard-readme-spec
# Prints out the standard-readme spec
```

### Generator

To use the generator, look at [generator-standard-readme](https://github.com/RichardLitt/generator-standard-readme). There is a global executable to run the generator in that package, aliased as `standard-readme`.



## Example Readmes

To see how the specification has been applied, see the [example-readmes](example-readmes/).

## Related Efforts

- [Art of Readme](https://github.com/noffle/art-of-readme) - 💌 Learn the art of writing quality READMEs.
- [open-source-template](https://github.com/davidbgk/open-source-template/) - A README template to encourage open-source contributions.

## Maintainers

[@JinCheng](https://github.com/Mighty-Frog/).

## Contributing


### Contributors
Cheng Jin , Lei Luojie

## License

[University of St Andrews](LICENSE) © Jin Cheng
