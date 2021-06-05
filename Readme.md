# Spring Core FrameWork

### Using Spring Framework

We can create the Java classes, and Objects can be injected by Spring Framework as per the configurations, and this is called as Dependency injection.

For that we need to add Spring Dependency first.

### 1. Bean Factory

We need to first install dependencies in the pom.xml file.
For example in pom.xml :

```
	<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context</artifactId>
	    <version>5.3.7</version>
	</dependency>

	
```
We need to do configurations to let Spring framework know which Object we want to insert.

We have 
	- xml based configurations.
	- Java based Configurations.
	- Annotations based configurations.

Then we can define a BeanFactory

```
		BeanFactory beanFactory = new XmlBeanFactory(FileSystemResource("spring.xml"));
        
        Car car = (Car) beanFactory.getBean("car");

```

We are doing XML based configurations here.So we need to add a Spring Based configuration File as well.

In that XML file we need to tell what is the Configuration we are trying to do and mention the settings.

```
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns = "http://www.springframework.org/schema/beans"
	   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
	   xsi:schemaLocation = "http://www.springframework.org/schema/beans
	   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
	
	
		<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car">		
	</bean>

	</beans>
```

### 2. Application Context

BeanFactory is deprecated and we should use Application Context. The updated code would look like :

```
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        Car car = (Car)context.getBean("car");
        car.driving();
```

### 3. Spring Container

Application context will create Spring Container which will contains beans.
Container will check spring.xml file and it will create all objects for us.

Beans will be called singleton beans as objects will be created only once.

### 4. Singleton vs Prototype

We can define scope also while defining the xml file for dependency injection.

```
	<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton"></bean>
```

But if we want object at run time, we will have to define the scope as prototype

```
	<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="prototype"></bean>
```

Bydefault it is singleton.

### 5. Setter Injection

If we want to inject variables using setter methods :

```
	<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton">
		<property name="name" value="mercedes"></property>
	</bean>	
```

If my variable is reference type, for example Car has a property tyre that is of reference type, then we can add that as below :

```
	<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton">
		<property name="name" value="mercedes"></property>
		<property name="tyre" ref="michelline"></property>
	</bean>	
	
	<bean id="michelline" class="com.rajat.spring.SpringCoreLearning.Tyre">
		<property name="size" value="16"></property>
		<property name="company" value="michilline"></property>
	</bean>
```

### 6. Constructor Injection

If we have a constructor defined in the POJO :

```
	public Car(String name) {
		this.name = name;
	}
	
```

There are 2 ways in which we can do constructor injection :

1 : Constructor arg in xml file:
	
	```
		<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton">
			<constructor-arg value="Maruti"></constructor-arg>
			<property name="tyre" ref="michelline"></property>
		</bean>	
	```
2.


### 7. Autowire

We can autowire by defining a bean, autowire = "default"

That would automatically load up the beans if they are available.
we can mention autowire = "byName" or autowire = "byType"

```
	<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton" autowire="byType">
		<constructor-arg value="Maruti"></constructor-arg>
		
	</bean>	
	
	<bean id="michelline" class="com.rajat.spring.SpringCoreLearning.Tyre">
		<property name="size" value="16"></property>
		<property name="company" value="michilline"></property>
	</bean>
```

If we have more than 2 candidates for the same bean, then we can assign, primary bean attribute , and it will make sure that it is selected first

	```
		<bean id = "car" class = "com.rajat.spring.SpringCoreLearning.Car" scope="singleton" autowire="byType">
		<constructor-arg value="Maruti"></constructor-arg>
		
		</bean>	
		
		<bean id="michelline" class="com.rajat.spring.SpringCoreLearning.Tyre">
			<property name="size" value="16"></property>
			<property name="company" value="michilline"></property>
		</bean>
		
		<bean id="apollo" class="com.rajat.spring.SpringCoreLearning.Tyre" primary="true">
			<property name="size" value="12"></property>
			<property name="company" value="Apollo"></property>
		</bean>
	```

# Important Points

- By Default Spring follows Singleton Design pattern.
- 







