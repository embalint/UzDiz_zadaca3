package controller;

import java.util.ArrayList;
import model.Model;
import utils.Writer;
import view.Frame;
import view.FrameFactory;

public class ViewController extends Controller {

    private Frame inputFrame;

    private ArrayList<Frame> outputFrames = new ArrayList<>();

    public ViewController() {

        FrameFactory factory = (FrameFactory) this.get("frame.factory");

        inputFrame = factory.makeInputFrame();
        Writer.writerNextPosition = inputFrame.getWriterStartPosition();

        this.outputFrames.add(factory.makeFrame(1, (Model) this.get("model.structure")));
        this.outputFrames.add(factory.makeFrame(2, (Model) this.get("model.info")));
    }

    @Override
    public void work() {

        inputFrame.render();

        for (Frame f : outputFrames) {
            f.render();
        }
    }

}
