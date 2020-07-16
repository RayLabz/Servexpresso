# Servexpresso

A Java service implementation library.

Servexpresso is a Java library that allows you to quickly and easily 
create abstract services. Such services can be used in several use cases:

1) Web Services - You can define web services that can be deployed on any web 
server environment using HTTP and REST.
2) Networking - You can define communication APIs between nodes in a 
network (i.e. using TCP/UDP socket channels). 
3) System-level libraries - You can define system-level APIs between different
devices or system components.
4) Test-driven development - You can define and test services without
the need to deploy them.

---

## Overview
The library revolves around the fact that all services of any type are essentially
functions that expect a set of input parameters, perform a sequence of processing steps 
and then return an output. This allows them to be abstracted on several levels with two
goals in mind:
1) To standardize their behavior.
2) To avoid any service-specific bugs, especially in parts where
the thought process and behavior is always the same.
3) To save time and effort by abstracting away functionality that is 
common to all services and allowing the programmer to focus only 
on implementing what makes each service unique.

## Service components
All services have three components:

* A set of expected parameters.
* An implementation.
* An output.

### Supported parameter types
Servexpresso automatically converts parameter values to and from their String-based counterparts. The following types are supported:
* String
* Boolean
* Double
* Long
* Integer
* Short
* Unsigned double
* Unsigned long
* Unsigned integer
* Unsigned short

## Defining a service
The following code defines a simple service that can add up to three numbers, with the third number being optional:

```java
final Service addService = new Service.Builder()
        .expectParam("number1", ParamType.INTEGER, true)
        .expectParam("number2", ParamType.INTEGER, true)
        .expectParam("number3", ParamType.INTEGER, false)
        .implement(input -> {
            int number1 = input.getInt("number1");
            int number2 = input.getInt("number2");
            int number3 = 0;
            if (input.paramExists("number3")) {
                number3 = input.getInt("number3");
            }
            int sum = number1 + number2 + number3;
            JsonObject data = new JsonObject();
            data.addProperty("sum", sum);
            return new SuccessResponse("Success", "Numbers added", data);
        })
        .build();
```

#### expectParam()
Each service can expect from 0 to any number of parameters. Each parameter is characterized by a name, an expected type (see above),
and if it is required or not.

The ```expectParam()``` method defines a parameter that should be expected
by the service and takes in three values:
1) The parameter name.
2) The parameter type (```ParamType```, see above).
3) A boolean value that indicates if the parameter is required or not.

**When a parameter is set to be required, Servexpresso will automatically check if it was provided to the service or not.
You do not need to check if required parameters have been provided to the service**. When a required parameter has not
been provided, Servexpresso will automatically return a ```MissingParametersResponse``` which indicates which parameters
are missing. On the other hand, you need to check the non-required parameters before using them, which can be done 
using the ```paramExists()``` method, as shown in the example above.

**Servexpresso will also check if the received type of a parameter matches its expected type. You do not need to check
if your parameters are of the expected type. You can assume that they have been checked and casted (if necessary) to that type.**
When a parameter contains a value that is not of its expected type, Servexpresso will automatically return a ```TypeMismatchResponse```
which indicates which parameters did not match their expected types.

When either a parameter is missing or a parameter type mismatch is detected, execution will stop and the implementation
 of the service will not be executed.

#### implement()
A service must be implemented before being used. A service's implementation is code that defines what will be 
executed when the service is called. In the implementation of a service, the input parameters provided to the service
can be accessed and processed to achieve a desired outcome or return an output. In the example above, a lambda expression 
is used with a variable called ```input```. Using this variable, you can access the values of input parameters.

When a parameter is not required, the programmer must make sure that this parameter was provided before using it. This
can be done by using the ```paramExists()``` method, which will return true if the parameter exists and false if it does not.

#### Output
A service returns a Response object as output. This object is based on the [Responz library](https://raylabz.github.io/Responz/) and
contains five pieces of data: status (```OK```/```ERROR```) title, message, date/time of the response, and data (optional).
You can add your output as data to the response by creating a new ```JsonObject``` 
(using the included [GSON library](https://github.com/google/gson)). A ```SuccessResponse``` indicates a successful
response (status=OK) whereas an ```ErrorResponse``` indicates a failed response (status=ERROR). You can also create your 
own custom responses by extending the ```Response``` class, as shown [here](https://raylabz.github.io/Responz/javaGuide.html#custom).

## Calling a service
The way you call a service depends on which environment you deploy it to. To run a service, call its ```processRequest()``` method
by providing a set of input parameters, in the following ways:

#### 1. Directly, using ```InputParam```
```java
final Response addResponse = addService.processRequest(
        new InputParam("number1", 3),
        new InputParam("number2", 6),
        new InputParam("number3", 1)
);
```
The ```InputParam``` object defines a new input parameter by associating it with a name and value.

#### 2. Directly, using an ```InputParams``` map
The ```InputParams``` map can hold multiple ```InputParam``` variables and associates them with their name as a key.

```java
InputParam param1 = new InputParam("number1", 3);
InputParam param2 = new InputParam("number2", 6);
InputParam param3 = new InputParam("number3", 1);

InputParams params = new InputParams();
params.put(param1.getName(), param1);
params.put(param2.getName(), param2);
params.put(param3.getName(), param3);

addService.processRequest(params);
```

This option should not be prefered unless you are creating your own method to automatically parse parameters sent to an
implementation-specific service. In this case, your method should parse the parameters and return an ```InputParams``` object
with their parsed values which can then be passed to ```processRequest()```. This is what is being done in the section below.

#### 3. Servlet-specific calls
You can use the ```InputParams.fromServletParams()``` method to convert servlet request parameters to an ```InputParams``` map
and then pass it to ```processRequest()```.
Assuming a Servlet called ```AdditionServlet```:
```java
public class AdditionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final InputParams params = InputParams.fromServletParams(req.getParameterMap());
        resp.getWriter().write(service.processRequest(params).toJSON());
    }

}
```

The ```fromServletParams()``` method automatically converts a ```Map<String, String[]>``` returned by the servlet's 
```req.getParameterMap()``` to an ```InputParams``` map.

#### 4. Creating your own implementation-specific methods
You can create your own implementation-specific conversion method which must return ```InputParams```. You can call such methods
in the same way as the above servlet-specific example. More such implementation-specific utility methods may be added in the future.

## Documentation
[View the documentation here](https://raylabz.github.io/Servexpresso/).

## License
