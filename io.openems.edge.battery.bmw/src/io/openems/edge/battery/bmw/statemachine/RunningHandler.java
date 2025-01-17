package io.openems.edge.battery.bmw.statemachine;

import io.openems.edge.battery.bmw.statemachine.StateMachine.State;
import io.openems.edge.common.startstop.StartStop;
import io.openems.edge.common.statemachine.StateHandler;

public class RunningHandler extends StateHandler<State, Context> {

	@Override
	public State runAndGetNextState(Context context) {
		final var battery = context.getParent();
		if (battery.hasFaults()) {
			return State.ERROR;
		}

		if (!battery.isRunning()) {
			battery._setUnexpectedRunningState(true);
			return State.ERROR;
		}

		battery._setStartStop(StartStop.START);
		return State.RUNNING;
	}
}
