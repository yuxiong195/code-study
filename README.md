# code-study

This project contains a Spring Boot + MyBatis example that exposes CRUD APIs for the `basic_model_config` table.

## Getting Started

1. Configure your MySQL datasource in `src/main/resources/application.yml`.
2. Ensure the `basic_model_config` table exists in your database using the provided schema.
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   or, if you have Maven installed:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

All endpoints are prefixed with `/api/basic-model-configs`.

| Method | Path | Description |
| ------ | ---- | ----------- |
| POST | `/` | Create a new configuration |
| GET | `/{id}` | Retrieve by primary key |
| GET | `/by-model/{modelId}` | Retrieve by `model_id` |
| GET | `/` | List all configurations |
| PUT | `/{id}` | Update a configuration |
| DELETE | `/{id}` | Delete a configuration |

Request and response bodies use the `BasicModelConfig` JSON structure mirroring the table columns.
