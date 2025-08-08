# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this module.

## Module Overview

The `e_commerce-endpoint-graphql` module is a Spring Boot GraphQL API endpoint that provides modern GraphQL access to e-commerce domain data. It serves as the primary API gateway for e-commerce functionality including web content management, user sessions, subscriptions, and analytics data through a unified GraphQL interface.

## Technology Stack

- **Framework**: Spring Boot 2.2.0.RELEASE
- **Java Version**: Java 13
- **Build Tool**: Maven
- **API**: GraphQL with GraphQL Java Tools
- **Database**: PostgreSQL via Spring Data JPA
- **Container**: Docker Compose support
- **Architecture**: Microservice with GraphQL API

## Project Structure

```
e_commerce-endpoint-graphql/
├── pom.xml                     # Maven build configuration
├── docker-compose.yml          # Local development setup
├── schema.graphql             # GraphQL schema definition
└── src/
    ├── main/
    │   ├── java/erp_microservices/e_commerce/endpoints/
    │   │   ├── Application.java           # Main Spring Boot application
    │   │   ├── graphql/                   # GraphQL resolvers and configuration
    │   │   ├── jpa_converters/           # Custom JPA converters
    │   │   ├── models/                   # JPA entity models
    │   │   └── repositories/             # Spring Data JPA repositories
    │   └── resources/
    │       ├── application.yml           # Configuration
    │       ├── META-INF/persistence.xml  # JPA configuration
    │       └── schema.graphqls           # GraphQL schema
    └── test/
        └── java/                        # Test classes
```

## Build and Development Commands

### Maven Commands
```bash
# Build the project
mvn clean compile

# Run the application
mvn spring-boot:run

# Run tests
mvn test

# Package the application
mvn package

# Generate dependency report
mvn dependency:tree
```

### Docker Operations
```bash
# Start local development environment
docker-compose up

# Start in background
docker-compose up -d

# Stop services
docker-compose down
```

## GraphQL Implementation

### Schema Definition (`schema.graphqls`)
The GraphQL schema defines:
- **Queries**: Read operations for e-commerce data
- **Mutations**: Write operations for content and user management
- **Subscriptions**: Real-time updates for user sessions and activities
- **Types**: Complex types for e-commerce entities

### Key GraphQL Types
- **WebContent**: Content management and publishing
- **User**: User authentication and profile information
- **Subscription**: User subscription and billing information
- **Visit**: User session and analytics tracking
- **ServerHit**: Performance and usage analytics

### Resolvers and Data Fetchers
GraphQL resolvers handle:
- **Query Resolution**: Efficient data fetching with N+1 problem mitigation
- **Field Resolution**: Custom field resolvers for computed properties
- **Mutation Handling**: Data modification and validation
- **Subscription Management**: Real-time data streaming

## JPA Entity Models

### Core E-commerce Entities
- **WebContentEntity**: Web content management
- **UserLoginEntity**: User authentication tracking
- **SubscriptionEntity**: User subscription management
- **VisitEntity**: User session analytics
- **ServerHitEntity**: Request performance tracking

### Supporting Entities
- **WebContentTypeEntity**: Content categorization
- **WebContentStatusTypeEntity**: Content lifecycle management
- **UserAgentEntity**: Browser and device detection
- **WebPreferenceEntity**: User customization settings

## Development Workflow

### Adding New GraphQL Operations
1. **Schema Design**: Define new types, queries, or mutations in `schema.graphqls`
2. **Entity Modeling**: Create or update JPA entities in the `models/` package
3. **Repository Layer**: Add Spring Data JPA repositories for data access
4. **Resolver Implementation**: Create GraphQL resolvers in the `graphql/` package
5. **Testing**: Write integration tests for GraphQL operations
6. **Documentation**: Update API documentation and examples

### GraphQL Best Practices
- **Schema-First Design**: Design GraphQL schema before implementation
- **Efficient Data Fetching**: Use DataLoader pattern to avoid N+1 queries
- **Input Validation**: Validate all mutation inputs thoroughly
- **Error Handling**: Provide meaningful error messages and types
- **Security**: Implement proper authentication and authorization

## Testing Standards

### GraphQL Testing
- **Query Testing**: Test all GraphQL queries with various parameters
- **Mutation Testing**: Verify data modifications and validation rules
- **Schema Validation**: Ensure schema consistency and backwards compatibility
- **Performance Testing**: Test query performance and optimization
- **Security Testing**: Verify authentication and authorization controls

### Integration Testing
- **Database Integration**: Test JPA repositories and entity relationships
- **GraphQL Integration**: End-to-end GraphQL operation testing
- **External Service Integration**: Mock external service dependencies
- **Container Testing**: Test Docker Compose development setup

## Configuration

### Application Configuration (`application.yml`)
- **Server Configuration**: Port and context path settings
- **Database Configuration**: PostgreSQL connection details
- **JPA Configuration**: Hibernate settings and SQL logging
- **GraphQL Configuration**: GraphQL endpoint and playground settings
- **Logging Configuration**: Application and query logging

### JPA Configuration (`persistence.xml`)
- **Persistence Unit**: JPA persistence unit configuration
- **Provider Settings**: Hibernate-specific configuration
- **Connection Settings**: Database connection parameters

## GraphQL API Usage

### Query Examples
```graphql
# Get web content with filtering
query {
  webContent(status: PUBLISHED, limit: 10) {
    id
    title
    content
    publishDate
    author {
      name
      email
    }
  }
}

# Get user subscription information
query {
  userSubscriptions(userId: "123") {
    id
    type
    status
    startDate
    endDate
    billing {
      amount
      currency
      nextBillingDate
    }
  }
}
```

### Mutation Examples
```graphql
# Create new web content
mutation {
  createWebContent(input: {
    title: "New Article"
    content: "Article content..."
    type: ARTICLE
  }) {
    id
    title
    status
    publishDate
  }
}

# Update user preferences
mutation {
  updateUserPreferences(userId: "123", preferences: {
    theme: DARK
    language: "en"
    notifications: true
  }) {
    id
    theme
    language
    notifications
  }
}
```

## Performance Considerations

### GraphQL Optimization
- **Query Complexity**: Implement query complexity analysis and limits
- **DataLoader**: Use DataLoader pattern for efficient batch loading
- **Caching**: Implement field-level and query-level caching
- **Pagination**: Implement cursor-based pagination for large datasets

### Database Optimization
- **Connection Pooling**: Configure appropriate database connection pooling
- **Query Optimization**: Monitor and optimize slow JPA queries
- **Indexing**: Ensure proper database indexes for GraphQL queries
- **Lazy Loading**: Configure appropriate JPA lazy loading strategies

## Security Considerations

### API Security
- **Authentication**: Implement JWT or OAuth2 authentication
- **Authorization**: Field-level and operation-level authorization
- **Rate Limiting**: Prevent abuse with query rate limiting
- **Query Depth Limiting**: Prevent overly complex nested queries

### Data Security
- **Input Sanitization**: Sanitize all GraphQL inputs
- **SQL Injection Prevention**: Use parameterized queries and JPA
- **Data Privacy**: Implement proper data access controls
- **Audit Logging**: Log all data access and modification operations

## Dependencies

### Core Dependencies
- **Spring Boot Starter Web**: Web application framework
- **Spring Boot Starter Data JPA**: Database access layer
- **Spring Boot Starter Actuator**: Monitoring and management
- **GraphQL Spring Boot Starter**: GraphQL integration
- **GraphQL Java Tools**: GraphQL schema and resolver handling
- **PostgreSQL Driver**: Database connectivity

### Development Dependencies
- **Spring Boot DevTools**: Development utilities
- **Spring Boot Starter Test**: Testing framework

## Docker Integration

### Development Setup
- **PostgreSQL Database**: Containerized database for development
- **Application Container**: Dockerized Spring Boot application
- **Network Configuration**: Container networking for service communication
- **Volume Mapping**: Development code and data persistence

## Integration Points

### E-commerce System Integration
- **Content Management**: Integration with content management systems
- **User Management**: User authentication and profile management
- **Analytics Systems**: User behavior and performance analytics
- **Payment Systems**: Subscription and billing integration

### External Service Integration
- **CDN Integration**: Content delivery network for web assets
- **Search Services**: Full-text search integration for content
- **Notification Systems**: Email and push notification services
- **Third-party Analytics**: Google Analytics, Adobe Analytics integration

## Important Notes

- **GraphQL Expertise**: Requires understanding of GraphQL best practices
- **Performance Critical**: E-commerce APIs require high performance and availability
- **Schema Evolution**: Careful management of GraphQL schema changes
- **Java 13**: Uses modern Java features - consider upgrade path planning
- **Spring Boot 2.2**: Mature Spring Boot version with GraphQL integration
- **Database Design**: Closely coupled with e_commerce-database schema