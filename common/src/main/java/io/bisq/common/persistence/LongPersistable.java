/*
 * This file is part of bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.common.persistence;

import com.google.protobuf.Message;
import io.bisq.generated.protobuffer.PB;
import lombok.Getter;
import lombok.experimental.Delegate;

public class LongPersistable implements Persistable {

    @Delegate
    @Getter
    Long longPayload;

    public LongPersistable(Long longPayload) {
        this.longPayload = longPayload;
    }

    @Override
    public Message toProto() {
        return PB.DiskEnvelope.newBuilder().setBloomFilterNonce(
                PB.LongPersistable.newBuilder().setLong(longPayload)).build();
    }
}