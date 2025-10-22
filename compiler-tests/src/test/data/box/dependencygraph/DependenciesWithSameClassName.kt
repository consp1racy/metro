// MODULE: lib
package otherpackage

@Inject
class Dependency

// MODULE: main(lib)
package thispackage

@Inject
class Dependency


@DependencyGraph
interface AppGraph {
    val thisDependency: thispackage.Dependency
    val otherDependency: otherpackage.Dependency
}


fun box(): String {
  val graph = createGraph<AppGraph>()
  assertTrue(graph.thisDependency is thispackage.Dependency)
  assertTrue(graph.otherDependency is otherpackage.Dependency)
  return "OK"
}
