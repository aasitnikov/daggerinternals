# Deep dive into Dagger generated code

This repository contains code from blog post series ["Deep dive into Dagger generated code"](https://proandroiddev.com/58f3cb9563de).

### [Part 1](https://proandroiddev.com/58f3cb9563de)

Interactor example - simple component with one `@Module` with `@Provides` method
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a1_interactor/InteractorComponent.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a1_interactor/generated/DaggerInteractorComponent.kt))

Repository example - class with empty `@Inject` constructor
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a2_repository/Repository.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a2_repository/generated/Repository_Factory.kt))

Repository example - class with `@Inject` constructor with parameters
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a3_repository/RepositoryComponent.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a3_repository/generated/Repository_Factory.kt))

Network module example - stateful `@Module` class with `@Provides` method with parameters 
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a4_modules/NetworkModule.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a4_modules/generated/NetworkModule_CreateApiServiceFactory.kt))

Network module example - stateless `@Module` object with static `@Provides` method
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a5_modules/NetworkModule.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a5_modules/generated/NetworkModule_CreateApiServiceFactory.kt))

Component dependencies ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/a6_dependencies/DependenciesComponent.kt)) 

### [Part 2](https://proandroiddev.com/13de4781b49d)

Custom component builder ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b1_builder_factory/BuilderComponent.kt))

Component factory ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b1_builder_factory/FactoryComponent.kt))

`@BindsInstance` ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b2_bindsinstance/BindsInstanceComponent.kt))

Component factory and component fields ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b3_full_factory/FullFactoryComponent.kt))

Activity - members-injection example 
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b4_membersinjection/Activity.kt),
[generated](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b4_membersinjection/generated/Activity_MembersInjector.kt))

BaseActivity - super members-injection example 
([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b5_super_membersinjection/MemberInjectionComponent.kt),
[generated for BaseActivity](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b5_super_membersinjection/generated/BaseActivity_MembersInjector.kt),
[generated for ChildActivity](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b5_super_membersinjection/generated/ChildActivity_MembersInjector.kt))

Components methods ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b6_component_methods/MethodsComponent.kt))

`@Binds` module methods ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b7_binds/BindsComponent.kt))

Qualifiers ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b8_qualifiers/QualifiersComponent.kt))

Qualifiers and Kotlin properties ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b9_qualifiers_properties/PropertyComponent.kt))

Multibindings ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/b10_multibindings/MultibindsComponent.kt))

### [Part 3](https://proandroiddev.com/2d1593ad154)

SingletonRepository example `@Singleton` with `@Inject` constructor ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c1_singleton/SingletonComponent.kt))

Custom scope annotation ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c2_custom_scope/CustomSingletonComponent.kt))

`@Reusable` scope ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c3_reusable/ScopedComponent.kt))

`Lazy` vs scopes ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c4_lazy/LazyComponent.kt))

Breaking circular dependencies using `Lazy` ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c5_circular/CircularComponent.kt))

Subcomponent ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c6_subcomponent/ParentComponent.kt))

Subcomponents in modules ([source](https://github.com/aasitnikov/daggerinternals/blob/master/src/main/java/com/example/c7_module_in_subcomponent/i12_subcomponents.kt))

