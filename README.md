## 说明
本demo抽取项目中的swagger代码生成器,根据swagger.yml生成api接口与实体类
目前存在问题swagger.yml中的info和schemes等属性设置无效,待后续研究.

### Use OpenAPI to generate codes

We use maven plugin `swagger-codegen-maven-plugin` to generate codes from OpenAPI. You can change the plugin
configuration in `pom.xml`.

1. Edit OpenAPI description file `src/main/resources/apis/apis.yml`
   . [OpenAPI (Swagger) Editor](https://marketplace.visualstudio.com/items?itemName=42Crunch.vscode-openapi) is
   recommended.
2. Run `mvn compile` to generate codes.
3. The generated codes are located in the `target/generated-sources/swagger/src/main/java` directory. Only interfaces
   and models are generated.
4. Create Controller class to implement the generated interface.
    1. Add `@RestController` annotation to the Controller class.
    2. Add the `@Api` annotation to the Controller class. Be careful to make its attribute `tags` consistent with the definition in the `apis.yaml` file.
5. Complete all the methods of the Controller.

### Browse and test the API via SwaggerUI

We added the SwaggerUI to the application automatically via the iot-common dependency. You can use the
URL `{host+port}/swagger-ui.html` to browse it.