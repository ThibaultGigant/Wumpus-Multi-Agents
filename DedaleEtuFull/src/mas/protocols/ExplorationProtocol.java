package mas.protocols;

import mas.abstractAgent;
import mas.behaviours.communication.AckReceiveKnowledgeBehaviour;
import mas.behaviours.communication.ReceiveKnowledgeBehaviour;
import mas.behaviours.communication.SendKnowledgeBehaviour;
import mas.behaviours.move.MoveBehaviour;
import mas.behaviours.move.ObservationBehaviour;
import mas.strategies.ExploreStrategy;
import mas.strategies.IStrategy;

/**
 * Protocole d'exploration
 * Ajoute les comportements liés à l'observation à l'agent passé en paramètre
 * Created by Tigig on 13/02/2016.
 */
public class ExplorationProtocol extends AbstractProtocol {
    @Override
    public void addBehaviours(abstractAgent myAgent) {
        behaviours.add(new ObservationBehaviour(myAgent, 90));

        IStrategy strategy = new ExploreStrategy();
        strategy.setMyAgent(myAgent);
        behaviours.add(new MoveBehaviour(myAgent, 100, strategy));

        behaviours.add(new SendKnowledgeBehaviour(myAgent, 1000));
        behaviours.add(new ReceiveKnowledgeBehaviour(myAgent));
        behaviours.add(new AckReceiveKnowledgeBehaviour(myAgent));

        behaviours.forEach(myAgent::addBehaviour);
    }
}
