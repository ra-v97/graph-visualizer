Template project for implementing tetrahedron-based (hyper)graph grammars productions.

Based on https://github.com/ra-v97/terrain-generator.

## Opis 
Program służy do konstrukcji hipergrafów, wykonywania na nich produkcji gramatycznych i wizualizacji ich ze szczególnym uwzględnieniem czworościanów i jest oparty o framework GraphStream. Po uruchomieniu jego czystej wersji zobaczymy wizualizację najprostszego czworościanu, czyli takiego hipergrafu nieskierowanego, który, z logicznej perspektywy, składa się z 4 wierzchołków połączonych sześcioma dwuelementowymi krawędziami w tzw. klikę, czyli każdy z każdym oraz czteroma trzyelementowymi hiperkrawędziami połączonymi w taki sposób, że każde dwie z nich współdzielą dwa wierzchołki. Od strony implementacji hiperkrawędź jest specjalnym rodzajem wierzchołka (dziedziczy po abstrakcyjnej klasie GraphNode podobnie jak Vertex).
Klasa Visualizer pozwala na wyświetlenie takiego hipergrafu z różnych perspektyw.

Struktura kodu jest prosta. GraphNode jest klasą abstrakcyjną, która dziedziczy po Nodzie z biblioteki GraphStream, a z niej dziedziczą Vertex (czyli zwykły wierzchołek) oraz FaceNode. GraphEdge to oczywiście krawędź, Coordinates ma współrzędne, ElementAttributes to mała klasa ze stringami pomocnymi przy wizualizacji no i GraphModel, który trzyma informacje o grafie i w którym jest większość logiki. No i klasa Vizualizer, która bierze graf i go wyświetla.

### Przydatne funkcje:

* ModelGraph::insertEdge() 
* ModelGraph::deleteEdge()
* ModelGraph::insertFace()
* ModelGraph::insertVertex()
* ModelGraph::removeFace()
* Coordinates::distance()
* Coordinates::middlePoint()
* Graph::getFace(id)
* GraphNode::getId()