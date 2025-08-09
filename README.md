# E-commerce GraphQL API

A Go-based GraphQL API for e-commerce functionality, providing shopping cart management, user preferences, subscriptions, and web content management.

## Features

- **Authentication & Authorization**: JWT-based authentication with session management
- **Shopping Cart**: Redis-powered session-based shopping cart with persistence
- **User Preferences**: Personalized user preference management
- **Subscriptions**: Subscription management system
- **Web Content Management**: Content and digital asset management
- **GraphQL API**: Comprehensive GraphQL schema with full CRUD operations
- **Session Management**: Redis-based session storage with automatic expiration
- **Docker Support**: Full containerization with Docker Compose

## Technology Stack

- **Go**: 1.23+
- **GraphQL**: gqlgen framework
- **Database**: PostgreSQL 15
- **Cache/Sessions**: Redis 7
- **HTTP Router**: Chi v5
- **Authentication**: JWT tokens
- **Testing**: Testify + BDD integration tests
- **Deployment**: Docker & Docker Compose

## Quick Start

### Prerequisites

- Go 1.23 or later
- Docker and Docker Compose
- PostgreSQL 15+ (if running locally)
- Redis 7+ (if running locally)

### Development Setup

1. **Clone and navigate to the project**:
   ```bash
   cd e_commerce-endpoint-graphql
   ```

2. **Install dependencies**:
   ```bash
   make deps
   ```

3. **Start development environment**:
   ```bash
   make docker-compose-up
   ```

4. **Run the application**:
   ```bash
   make run
   ```

5. **Access the GraphQL Playground**:
   Open http://localhost:8080/playground

### Using Make Commands

```bash
# Development
make run                    # Run locally
make dev                    # Run with hot reload
make generate              # Generate GraphQL code

# Testing
make test                  # Run all tests
make test-unit            # Run unit tests only  
make test-integration     # Run integration tests only
make test-bdd             # Run BDD tests
make test-coverage        # Generate coverage report

# Quality
make lint                 # Run linters
make fmt                  # Format code
make quality              # Run all quality checks

# Docker
make docker-build         # Build Docker image
make docker-compose-up    # Start all services
make docker-compose-down  # Stop all services

# Database
make db-migrate-up        # Run migrations
make db-migrate-down      # Rollback migrations
make db-reset             # Reset database

# Utilities
make help                 # Show all commands
```

## Project Structure

```
e_commerce-endpoint-graphql/
├── cmd/server/                 # Application entry point
├── internal/
│   ├── config/                # Configuration management
│   ├── middleware/            # HTTP middleware (auth, logging)
│   ├── model/                # Database models
│   ├── repository/           # Data access layer
│   └── service/              # Business logic layer
├── graph/                    # GraphQL schema and resolvers
│   ├── generated/           # Generated GraphQL code
│   └── model/              # GraphQL models
├── pkg/                     # Reusable packages
│   ├── scalars/           # Custom GraphQL scalars
│   └── session/           # Session management
├── test/                   # Test files
│   ├── integration/       # Integration tests
│   └── unit/             # Unit tests
├── docker-compose.yml     # Development environment
├── Dockerfile             # Container build
├── Makefile              # Build commands
└── schema.graphql        # GraphQL schema definition
```

## GraphQL Schema

### Key Operations

**Authentication**:
```graphql
mutation {
  login(credentials: {userId: "user@example.com", password: "password"}) {
    token
    user { id userId active }
    sessionId
  }
}

mutation {
  register(input: {userId: "user@example.com", password: "password"}) {
    token
    user { id userId active }
    sessionId
  }
}
```

**Shopping Cart**:
```graphql
mutation {
  addToCart(input: {productId: "123", quantity: 2, unitPrice: 29.99}) {
    id
    productId
    quantity
    totalPrice
  }
}

query {
  shoppingCart {
    sessionId
    items { id productId quantity unitPrice totalPrice }
    totalItems
    totalAmount
  }
}
```

**User Preferences**:
```graphql
mutation {
  setUserPreference(input: {typeId: "123", value: "dark"}) {
    id
    value
    type { description }
  }
}

query {
  userPreferences {
    id
    value
    type { description }
  }
}
```

## Configuration

Configuration can be provided via:
1. YAML file (config.yaml)
2. Environment variables (prefixed with `ECOMMERCE_`)

Copy `config.example.yaml` to `config.yaml` and modify as needed.

### Environment Variables

```bash
# Database
ECOMMERCE_DATABASE_HOST=localhost
ECOMMERCE_DATABASE_PORT=5432
ECOMMERCE_DATABASE_NAME=e_commerce_db
ECOMMERCE_DATABASE_USER=e_commerce_user
ECOMMERCE_DATABASE_PASSWORD=e_commerce_password

# Redis
ECOMMERCE_REDIS_ADDR=localhost:6379

# Server
ECOMMERCE_SERVER_PORT=8080
ECOMMERCE_SERVER_ENABLE_PLAYGROUND=true

# Authentication
ECOMMERCE_AUTH_JWT_SECRET=your-secret-here
```

## Testing

The project includes comprehensive testing:

- **Unit Tests**: Test individual components in isolation
- **Integration Tests**: Test component interactions
- **BDD Tests**: Business-driven scenarios matching feature files

```bash
# Run all tests
make test

# Run with coverage
make test-coverage

# Run BDD tests (requires features module)
make test-bdd
```

## BDD Integration

The project integrates with e_commerce-features for BDD testing:

- Feature scenarios from `../e_commerce-features/` 
- Automated scenario execution
- Integration with CI/CD pipeline

## Database Schema

The API connects to the e_commerce database with tables for:

- `user_login` - User authentication
- `web_content` - Content management
- `web_preference_type` / `web_user_preference` - User preferences
- `subscription` - Subscription management
- `web_object` - Digital assets
- And more...

See `../e_commerce-database/sql/` for complete schema.

## Development Workflow

1. **Create feature branch**
2. **Write/update tests** (BDD scenarios, unit tests)
3. **Implement functionality**
4. **Run quality checks**: `make quality`
5. **Run all tests**: `make test`
6. **Build and test locally**: `make docker-build && make docker-compose-up`
7. **Create pull request**

## Deployment

### Docker Production

```bash
# Build production image
make docker-build

# Deploy with environment-specific config
docker run -d \
  --name e-commerce-api \
  -p 8080:8080 \
  -e ECOMMERCE_DATABASE_HOST=prod-db \
  -e ECOMMERCE_REDIS_ADDR=prod-redis:6379 \
  -e ECOMMERCE_AUTH_JWT_SECRET=prod-secret \
  erp-microservices/e-commerce-graphql-api:latest
```

### Health Checks

- **Health endpoint**: GET `/health`
- **GraphQL introspection**: Available in playground
- **Docker health checks**: Built into containers

## API Documentation

- **GraphQL Playground**: http://localhost:8080/playground (development)
- **Schema introspection**: Available through GraphQL endpoint
- **Postman collection**: Available in `/docs` (if present)

## Contributing

1. Follow existing code patterns
2. Write comprehensive tests
3. Update documentation
4. Run quality checks
5. Ensure BDD scenarios pass

## License

Apache 2.0 License - see LICENSE file