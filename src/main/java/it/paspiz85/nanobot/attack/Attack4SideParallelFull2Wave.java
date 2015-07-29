package it.paspiz85.nanobot.attack;

import it.paspiz85.nanobot.util.Point;

/**
 * Attack from 4 side parallel (top and bottom) in 2 wave of units.
 *
 * @author paspiz85
 *
 */
public final class Attack4SideParallelFull2Wave extends Attack {

    Attack4SideParallelFull2Wave() {
    }

    @Override
    protected void doDropUnits(final int[] attackGroup) throws InterruptedException {
        for (int wave = 0; wave < 2; wave++) {
            for (int unitIdx = 0; unitIdx < attackGroup.length; unitIdx++) {
                int unitCount = attackGroup[unitIdx];
                unitCount = unitCount / 2 + wave * (unitCount % 2);
                // select unit
                platform.leftClick(getButtonAttackUnit(unitIdx + 1), true);
                platform.sleepRandom(100);
                final Point[] topToRightPoints = pointsBetweenFromToInclusive(TOP, RIGHT, unitCount / 4 + unitCount % 4);
                final Point[] topToLeftPoints = pointsBetweenFromToInclusive(TOP, LEFT, unitCount / 4);
                final Point[] rightToBottomPoints = pointsBetweenFromToInclusive(RIGHT, BOTTOM_RIGHT, unitCount / 4);
                final Point[] leftToBottomPoints = pointsBetweenFromToInclusive(LEFT, BOTTOM_LEFT, unitCount / 4);
                // drop units
                // top to mid from both sides in parallel
                for (int i = 0; i < topToRightPoints.length; i++) {
                    final Point topRightPoint = topToRightPoints[i];
                    platform.leftClick(topRightPoint, false);
                    platform.sleepRandom(PAUSE_BETWEEN_UNIT_DROP);
                    if (i < topToLeftPoints.length) {
                        final Point topLeftPoint = topToLeftPoints[i];
                        platform.leftClick(topLeftPoint, false);
                        platform.sleepRandom(PAUSE_BETWEEN_UNIT_DROP);
                    }
                }
                // select unit
                platform.leftClick(getButtonAttackUnit(unitIdx + 1), true);
                platform.sleepRandom(100);
                // mid to bottom from both sides in parallel
                for (int i = 0; i < rightToBottomPoints.length; i++) {
                    final Point rightToBottomPoint = rightToBottomPoints[i];
                    platform.leftClick(rightToBottomPoint, false);
                    platform.sleepRandom(PAUSE_BETWEEN_UNIT_DROP);
                    final Point leftToBottomPoint = leftToBottomPoints[i];
                    platform.leftClick(leftToBottomPoint, false);
                    platform.sleepRandom(PAUSE_BETWEEN_UNIT_DROP);
                }
            }
        }
    }

    @Override
    protected String getDescription() {
        return "Dropping units from 4 sides in parallel in 2 full waves";
    }
}
